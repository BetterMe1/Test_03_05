package Test_0305;

/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false
 */
/*
 * 分析：
 * 双指针i、j,一个从前往后遍历，一个从后往前遍历，用a、b记录i、j所指字符的ASCII值，当所指字符为大写字母时，将其转为小写字母的ASCII值（加32），
 * 判断a、b是否是在小写字母或数字的ASCII值范围内，是则判断a是否等于b，不等于返回false,等于时i指针加一，j指针减一,
 * 接着判断a是否超出范围，是则i指针加一；判断b是否超出范围，是则j指针减一,
 * 直到i不小于j跳出循环，返回true。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		String s = "A man, a plan, a canal: Panama";
//		System.out.println(So.isPalindrome(s));
//	}
//}
//class Solution {
//    public boolean isPalindrome(String s) {
//        int i = 0;
//        int j =s.length()-1;
//        while(i<j){
//        	int a = (int)s.charAt(i);
//        	int b = (int)s.charAt(j);
//        	if(65<= (int)s.charAt(i) && (int)s.charAt(i)<=90){
//        		a += 32;
//        	}
//        	if(65<= (int)s.charAt(j) && (int)s.charAt(j)<=90){
//        		b += 32;
//        	}
//        	if(((48<= a && a<=57) || (97<= a && a<=122)) && ((48<= b && b<=57) ||(97<= b && b<=122))){
//        		if(a != b){
//        			return false;
//        		}else{
//        			i++;
//        			j--;
//        		}	
//        	}
//        	if(48> a || (57<a && a<97) || a>122){
//        		i++;
//        	}
//        	if(48> b || (57<b && b<97) || b>122){
//        		j--;
//        	}	
//        }
//        return true;
//    }
//}
/*
136. 只出现一次的数字
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例 2:
输入: [4,1,2,1,2]
输出: 4
 */
/*
 分析：
异或操作可以使我们巧妙地排除成对出现的数字，找出单独的数字，
两数相等“按位异或”会得零，零与任何数异或，得到任何数本身
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] nums = {2,2,1};
//		System.out.println(So.singleNumber(nums));
//	}
//}
//class Solution {
//    public int singleNumber(int[] nums) {
//        for(int i=1; i<nums.length; i++){
//        	nums[0] ^= nums[i];
//        }
//        return nums[0];
//    }
//}

/*
260. 只出现一次的数字 III
 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
示例 :
输入: [1,2,1,3,2,5]
输出: [3,5]
注意：
结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
/*
 * 分析：
 * 先对nums数组内所有的数异或一遍，结果用a记录，a便是num1和num2异或的结果，
 * 然后找到num1与num2不同的一位，用b记录这个位置，
 * 最后再进行一遍for循环遍历，将nums数组中的数分为两拨，一拨在b记录的位置为0，与num1做异或操作，
 * 一拨在b记录的位置不为0,与num2做异或操作，
 * 最终得到的两个数字都出现一次，因为其他在这一位为0或不为0的数字都出现了两次或零次，被异或操作消除了。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {1,2,1,3,2,5};
		int[] res = So.singleNumber(nums);
		System.out.println(res[0] + " " + res[1]);
	}
}
class Solution {
    public int[] singleNumber(int[] nums) {
    	int num1 = 0;
    	int num2 = 0;
        //先异或一遍,得到num1和num2异或的结果
    	int a = 0;
    	for(int i=0; i<nums.length; i++){
    		a ^= nums[i];
    	}
    	//找到num1与num2不同的一位
    	int b = 1;
    	while((a & 1) ==0){
    		a >>= 1;
    	    b <<= 1;//记录不同的位置
    	}
    	//将nums数组中的数分为两拨，一拨在b记录的位置为0，与num1做异或操作，一拨在b记录的位置不为0,与num2做异或操作，
    	//最终得到的两个数字都出现一次，因为其他在这一位为0或不为0的数字都出现了两次或零次，被异或操作消除了。
    	for(int i=0; i<nums.length; i++){
    		if((nums[i] & b) == 0){
    			num1 ^= nums[i];
    		}else{
    			num2 ^= nums[i];
    		}
    	}
    	return new int[] {num1,num2};
    }
}