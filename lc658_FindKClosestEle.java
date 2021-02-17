class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        Priority Queue
        compare abs , if ==, compare a ,b
        
        */
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> Math.abs(a - x) == Math.abs(b - x) ? b - a : Math.abs(b - x) - Math.abs(a - x));
        
        for (int ele : arr) {
            pq.offer(ele);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}




class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }
}