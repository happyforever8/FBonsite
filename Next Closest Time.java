Given a time represented in the format "HH:MM", form the next closest time 
by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

 

Example 1:

Input: time = "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: time = "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
  
  
  
  class Solution {
    
//     全部用数据来比较，小于10的数字都不考虑前面加0，最后format返回值，组装结果时再补十位的0。
// 把time中的数字解析出来放入set，并组合成所有情况，并排序。


    
      public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        char[] timeChar = time.toCharArray();
        //把time中的数字解析出来放入set
        for (int i = 0; i < timeChar.length; i++) {
            if (i == 2) {
                continue;
            } else {
                set.add(timeChar[i]);
            }
        }
        if (set.size() == 1) {
            return time;
        }
        //组合成所有情况并排序
        List<Integer> allData = getAllData(set);
        Collections.sort(allData);

        //分解出时间的时和分
        int hour = Integer.valueOf(time.split(":")[0]);
        int second = Integer.valueOf(time.split(":")[1]);

        //重点： 先检查秒second所在的位置，如果他后面还有值，那么最近时刻一定是 当前的hour和indexSecond+1位置上的秒的组合
        int indexSecond = allData.indexOf(second);
        if (indexSecond < allData.size() - 1) {
            return formatResult(hour, allData.get(indexSecond + 1));
        }
        // 检查hour所在的位置，如果他后面还有值并且是24以内，那么最近时刻一定是indexHour+1所在的值 和 第0位的位置上的秒的组合
        int indexHour = allData.indexOf(hour);
        if (indexHour < allData.size() - 1 && allData.get(indexHour + 1) < 24) {
            return formatResult(allData.get(indexHour + 1), allData.get(0));
        }
        // 其余情况 取第一位的hour 和second
        return formatResult(allData.get(0), allData.get(0));
    }

    private String formatResult(int hour, int second) {
        //组装结果时再补十位的0
        StringBuffer sb = new StringBuffer();
        if (hour < 10) {
            sb.append("0");
        }
        sb.append(hour).append(":");
        if (second < 10) {
            sb.append("0");
        }
        sb.append(second);

        return sb.toString();
    }

    private List<Integer> getAllData(Set<Character> set) {
        List<Integer> allData = new ArrayList<>();
        for (Character first : set) {
            for (Character second : set) {
                int newData = Integer.valueOf(first + "" + second);
                //排列组合值考虑小于等于59的值
                if (newData >= 0 && newData <= 59 && !allData.contains(newData)) {
                    allData.add(newData);
                }
            }
        }
        return allData;
    }
}

