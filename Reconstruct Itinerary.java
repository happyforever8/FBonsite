ou are given a list of airline tickets where tickets[i] = [fromi, toi]
represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary
must begin with "JFK". If there are multiple valid itineraries, 
you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:


Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:


Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
  
  
  class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        
        if (tickets == null || tickets.size() == 0){
            return result;
        }
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (List<String> ticket : tickets){
            map.put(ticket.get(0), new PriorityQueue<>());
            
            for (int i = 1; i < ticket.size(); i++){
                map.get(ticket.get(0)).offer(ticket.get(1));;
            }
        }
        helper(result, map, "JFK");
        return result;
        
    }
    public void helper(LinkedList<String> result, Map<String, PriorityQueue<String>> map, String departure){
        PriorityQueue<String> arrivals = map.get(departure);
        while (arrivals != null && arrivals.size() > 0){
            helper(result, map, arrivals.poll());
        }
        result.addFirst(departure);
    }
        
//         Map<String, PriorityQueue<String>> map = new HashMap<>();
        
//         LinkedList<String> path = new LinkedList<>();
        
//         for (List<String> list : tickets){
//             map.putIfAbsent(list.get(0), new PriorityQueue<>());
//             for (int i = 1; i < list.size(); i++){
//                 map.get(list.get(0)).add(list.get(i));
//             }
//         }
                
//         helper(map, path, "JFK");
//         return path;
//     }
    
//     public void helper(Map<String, PriorityQueue<String>> map, LinkedList<String> path, String departure){
//         PriorityQueue<String> arrivals = map.get(departure);
//         while (arrivals != null && !arrivals.isEmpty()){
//             helper(map, path, arrivals.poll());
//         }
//         path.addFirst(departure);
//    }
}

// JFK  ATL SF0
// SF0  ATL
// ATL  JFK SF0
 // PriorityQueue<String> arrivals = flights.get(departure);
 //        while (arrivals != null && !arrivals.isEmpty()){
 //            helper(arrivals.poll());
 //        }
 //        path.addFirst(departure);
