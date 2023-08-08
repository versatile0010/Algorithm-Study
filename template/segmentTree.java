public static class segmentTree {
        long[] tree;
        int N;

        public segmentTree(int n, int[] arr) {
            N = n;
            tree = new long[n * 4];
            build(arr, 1, 0, n - 1);
        }

        public long build(int[] arr, int node, int nodeLeft, int nodeRight) {
            if (nodeLeft == nodeRight) { // leaf 에 도달함
                return tree[node] = arr[nodeLeft];
            }
            int mid = nodeLeft + (nodeRight - nodeLeft) / 2; // overflow 방지
            long leftVal = build(arr, node * 2, nodeLeft, mid);
            long rightVal = build(arr, node * 2 + 1, mid + 1, nodeRight);
            return tree[node] = merge(leftVal, rightVal);
        }

        public long merge(long left, long right) {
            return left + right; // sum
            // return Math.min(left, right); // min
            // return Math.max(left, right); // max
        }

        public Long query(int left, int right) {
            // 실제 입력 배열에서 [left, right] 구간에서의 query 결과값 반환
            return queryRecursive(left, right, 1, 0, N - 1);
        }

        public Long update(int index, int newValue) {
            return updateRecursive(index, newValue, 1, 0, N - 1);
        }

        public Long updateRange(int left, int right, int newValue) {
            return updateRangeRecursive(left, right, newValue, 1, 0, N - 1);
        }

        private Long queryRecursive(int left, int right, int node, int nodeLeft, int nodeRight) {
            if (right < nodeLeft || nodeRight < left) {
                return 0L; // 해당 노드 미포함
            }
            if (left <= nodeLeft && nodeRight <= right) {
                return tree[node];
            }
            int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
            return merge(queryRecursive(left, right, node * 2, nodeLeft, mid),
                    queryRecursive(left, right, node * 2 + 1, mid + 1, nodeRight));
        }

        private Long updateRecursive(int index, int newValue, int node, int nodeLeft, int nodeRight) {
            if (index < nodeLeft || nodeRight < index) {
                return tree[node];
            }
            if (nodeLeft == nodeRight) { // 리프 노드에 도달하면
                return tree[node] = newValue;
            }
            int mid = nodeLeft + (nodeRight - nodeLeft) / 2;

            Long leftVal = updateRecursive(index, newValue, node * 2, nodeLeft, mid);
            Long rightVal = updateRecursive(index, newValue, node * 2 + 1, mid + 1, nodeRight);

            return tree[node] = merge(leftVal, rightVal);
        }

        private Long updateRangeRecursive(int left, int right, int newValue, int node, int nodeLeft, int nodeRight) {
            if (right < nodeLeft || nodeRight < left) {
                return tree[node];
            }
            if (nodeLeft == nodeRight) {
                return tree[node] = newValue;
            }
            int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
            Long leftVal = updateRangeRecursive(left, right, newValue, node * 2, nodeLeft, mid);
            Long rightVal = updateRangeRecursive(left, right, newValue, node * 2 + 1, mid + 1, nodeRight);
            return tree[node] = merge(leftVal, rightVal);
        }
    }
