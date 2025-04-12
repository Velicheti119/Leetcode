class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        if(edges.size() > n - 1) {
            return false;
        } // Tree has n-1 edges.
        
        vector<vector<int>> adj(n);
        unordered_set<int> visit;
        for(const auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }

        if(!dfs(0, -1, visit, adj)) {
            return false;
        }

        return visit.size() == n;

    }

    bool dfs(int node, int parent, unordered_set<int>& visit, vector<vector<int>>& adj) {
        if(visit.count(node)) { // cycle
            return false;
        }

        visit.insert(node);
        for(int i : adj[node]) {
            if(i == parent) {
                continue;
            }
            if(!dfs(i, node, visit, adj)) {
                return false;
            }
        }
        return true;
    }
};
