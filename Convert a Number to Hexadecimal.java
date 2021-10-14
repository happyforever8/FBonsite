Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
  
  
  class Solution {
    
// 1.首先定义按照大小顺序定义一个字符hex“0123456789abcdef”
// 2.num的二进制表示和0xf(0000 0000 0000 1111)进行与运算后，只保留了最后四位，由此可以在hex中索引对应的十六进制表示
// 3.将num右移4位，处理num的下一个十六进制位，重复操作2
// 4.在右移次数不超过8的情况下重复2-3

    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
       StringBuilder sb = new StringBuilder();
         char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


        while (num != 0){
            sb.append(map[num & 15]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
