package Test_0305;

/*
125. ��֤���Ĵ�
����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:
����: "A man, a plan, a canal: Panama"
���: true
ʾ�� 2:
����: "race a car"
���: false
 */
/*
 * ������
 * ˫ָ��i��j,һ����ǰ���������һ���Ӻ���ǰ��������a��b��¼i��j��ָ�ַ���ASCIIֵ������ָ�ַ�Ϊ��д��ĸʱ������תΪСд��ĸ��ASCIIֵ����32����
 * �ж�a��b�Ƿ�����Сд��ĸ�����ֵ�ASCIIֵ��Χ�ڣ������ж�a�Ƿ����b�������ڷ���false,����ʱiָ���һ��jָ���һ,
 * �����ж�a�Ƿ񳬳���Χ������iָ���һ���ж�b�Ƿ񳬳���Χ������jָ���һ,
 * ֱ��i��С��j����ѭ��������true��
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
136. ֻ����һ�ε�����
 ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
˵����
����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
ʾ�� 1:
����: [2,2,1]
���: 1
ʾ�� 2:
����: [4,1,2,1,2]
���: 4
 */
/*
 ������
����������ʹ����������ų��ɶԳ��ֵ����֣��ҳ����������֣�
������ȡ���λ��򡱻���㣬�����κ�����򣬵õ��κ�������
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
260. ֻ����һ�ε����� III
 ����һ���������� nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ� �ҳ�ֻ����һ�ε�������Ԫ�ء�
ʾ�� :
����: [1,2,1,3,2,5]
���: [3,5]
ע�⣺
��������˳�򲢲���Ҫ��������������ӣ� [5, 3] Ҳ����ȷ�𰸡�
����㷨Ӧ�þ�������ʱ�临�Ӷȡ����ܷ��ʹ�ó����ռ临�Ӷ���ʵ�֣�
 */
/*
 * ������
 * �ȶ�nums���������е������һ�飬�����a��¼��a����num1��num2���Ľ����
 * Ȼ���ҵ�num1��num2��ͬ��һλ����b��¼���λ�ã�
 * ����ٽ���һ��forѭ����������nums�����е�����Ϊ������һ����b��¼��λ��Ϊ0����num1����������
 * һ����b��¼��λ�ò�Ϊ0,��num2����������
 * ���յõ����������ֶ�����һ�Σ���Ϊ��������һλΪ0��Ϊ0�����ֶ����������λ���Σ��������������ˡ�
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
        //�����һ��,�õ�num1��num2���Ľ��
    	int a = 0;
    	for(int i=0; i<nums.length; i++){
    		a ^= nums[i];
    	}
    	//�ҵ�num1��num2��ͬ��һλ
    	int b = 1;
    	while((a & 1) ==0){
    		a >>= 1;
    	    b <<= 1;//��¼��ͬ��λ��
    	}
    	//��nums�����е�����Ϊ������һ����b��¼��λ��Ϊ0����num1����������һ����b��¼��λ�ò�Ϊ0,��num2����������
    	//���յõ����������ֶ�����һ�Σ���Ϊ��������һλΪ0��Ϊ0�����ֶ����������λ���Σ��������������ˡ�
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