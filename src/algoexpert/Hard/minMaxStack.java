package algoexpert.Hard;

import java.util.Stack;

public class minMaxStack {
    public static void main(String[] args) {
        MinMaxStack st = new MinMaxStack();
        st.push(5);
        st.getMin();
        st.getMax();
        st.peek();
        st.push(7);

        st.getMin();
        st.getMax();
        st.peek();
        st.push(2);

        st.getMin();
        st.getMax();
        st.peek();
        st.pop();
        st.pop();

        st.getMin();
        st.getMax();
        st.peek();
    }
    static class MinMaxStack {
        int minVal = -1;
        private int maxVal = -1;
        private Stack<Integer> st = new Stack<Integer>();
        public int peek() {
            // Write your code here.
            int pVal = st.peek();
            int PeakVal = 0;
            if(pVal < minVal)
            {
                PeakVal = minVal;
            }
            else if(pVal > maxVal){
                PeakVal = maxVal;
            }
            else {
                PeakVal = pVal;
            }
            return PeakVal;
        }

        public int pop() {
            // Write your code here.
            if(st.empty())
                return -1;
            int pVal = st.peek();
            int popVal = pVal;
            if(pVal < minVal)
            {
                popVal = minVal;
                minVal = 2*minVal - pVal;
            }
            else if(pVal > maxVal){
                popVal = maxVal;
                maxVal = 2*maxVal - pVal;
            }
            st.pop();
            if(st.empty()) {
                minVal = -1;
                maxVal = -1;
            }
            return popVal;
        }

        public void push(Integer number) {
            // Write your code here.
            if(st.empty()) {
                st.push(number);
                minVal = number;
                maxVal = number;
                return;
            }
            if(number < minVal) {
                st.push(2*number - minVal);
                minVal = number;
            }
            else if(number > maxVal){
                st.push(2*number - maxVal);
                maxVal = number;
            }
            else {
                st.push(number);
            }
        }

        public int getMin() {
            // Write your code here.
            return minVal;
        }

        public int getMax() {
            // Write your code here.
            return maxVal;
        }
    }
}
