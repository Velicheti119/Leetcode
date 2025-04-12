class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> flow(numCourses);
        vector<bool> visit(numCourses, false);

        for(const auto& req : prerequisites) {
            flow[req[0]].push_back(req[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(dfs(i, flow, visit)) {
                return false;
            }
        }
        return true;
    }

    bool dfs(int course, vector<vector<int>>& flow, vector<bool>& visit) {
        if(visit[course]) {
            return true;
        }

        visit[course] = true;
        for(int prereq : flow[course]) {
            if(dfs(prereq, flow, visit)) {
                return true;
            }
        }
        visit[course] = false;
        return false;
    }
};
