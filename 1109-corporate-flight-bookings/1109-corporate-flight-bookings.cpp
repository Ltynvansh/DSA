class Solution {
public:
    vector<int> corpFlightBookings(vector<vector<int>>& bookings, int n) {
        vector<int> noOfBookingEachFlight(n + 1, 0);

        for(int i = 0; i < bookings.size(); i++) {
            int firstFlight = bookings[i][0];
            int lastFlight = bookings[i][1];
            int seats = bookings[i][2];

            noOfBookingEachFlight[firstFlight] += seats;

            if(lastFlight + 1 <= n) {
                noOfBookingEachFlight[lastFlight + 1] -= seats;
            }
        }

        // Prefix Sum
        for(int i = 1; i <= n; i++) {
            noOfBookingEachFlight[i] += noOfBookingEachFlight[i - 1];
        }

        vector<int> ans(n, 0);

        for(int i = 0; i < n; i++) {
            ans[i] = noOfBookingEachFlight[i + 1];
        }

        return ans;
    }
};