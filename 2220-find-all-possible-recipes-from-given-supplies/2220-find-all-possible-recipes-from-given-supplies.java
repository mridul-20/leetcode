class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String , List<String>> needs = new HashMap<>();

        for(int i = 0; i< recipes.length ; i++){
            needs.put(recipes[i] , ingredients.get(i));
        }

        boolean update = true;
        while(update){
            update = false;

            for(String r : recipes){
                if(available.contains(r)) continue;

                boolean canMake = true;
                for(String k : needs.get(r)){
                    if(!available.contains(k)){
                        canMake = false;
                        break;
                    }
                }
                if(canMake){
                    available.add(r);
                    update = true;
                }
            }
            
        }
        List<String> res = new ArrayList<>();
        for(String r : recipes){
            if(available.contains(r)) res.add(r);
        }
        return res;
    }
}