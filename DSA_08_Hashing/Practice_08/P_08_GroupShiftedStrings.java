public static final int ALPHA = 26;
 
    // Method to a difference string for a given string.
    // If string is "adf" then difference string will be
    // "cb" (first difference 3 then difference 2)
    public static String getDiffString(String str) {
        String shift = "";
        for (int i = 1; i < str.length(); i++) {
            int dif = str.charAt(i) - str.charAt(i - 1);
            if (dif < 0)
                dif += ALPHA;
 
            // Representing the difference as char
            shift += (char)(dif + 'a');
        }
        // This string will be 1 less length than str
        return shift;
    }
 
    // Method for grouping shifted string
    public static void groupShiftedString(String[] str) {
        // map for storing indices of string which are
        // in same group
        Map< String, List<Integer> > groupMap = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            String diffStr = getDiffString(str[i]);
            List<Integer> indices = groupMap.getOrDefault(diffStr, new ArrayList<>());
            indices.add(i);
            groupMap.put(diffStr, indices);
        }
 
        // iterating through map to print group
        for (Map.Entry<String, List<Integer>> entry : groupMap.entrySet()) {
            List<Integer> v = entry.getValue();
            for (int i = 0; i < v.size(); i++)
                System.out.print(str[v.get(i)] + " ");
            System.out.println();
        }
    }