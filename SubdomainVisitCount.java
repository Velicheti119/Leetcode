/*
Given: Array of count-paired-domains
Output: Array of count paired domains of each subdomain.
Problems at hand: Given a string "r d1.d2" or "r d1.d2.d3" we have to split "r" and the domain. Additionally split the domain into subdomains. And keep track of counts in the HashMap.
 */

class Solution {


    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        for (String cp : cpdomains) {
            String[] initSplit = cp.split(" ");
            int count = Integer.parseInt(initSplit[0]);
            String domain = initSplit[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for(int i = 0; i < domain.length(); i++) {
                if(domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
