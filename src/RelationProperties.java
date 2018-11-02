package Oving9;

class RelationProperties {
    /*
     * Assuming that a two column array containing the relation and a one column
     * * array containing the set the relation is on is given in each method.
     * No checks are performed.
     */

    public static boolean isReflexive(char[][] relation, char[] set) {

        int reflexive = 0;

        for (int j = 0; j < relation[0].length; j++) {
            char check = relation[j][j];
            for (int k = 0; k < relation.length; k++) {
                if (relation[j][j] == check && relation[k][j] == check) {
                    reflexive++;
                }
            }
        }

        if (reflexive == set.length) {
            return true;
        }

        return false;
    }

    public static boolean isSymmetric(char[][] relation, char[] set) {

        int symmetric1 = 0;
        int symmetric2 = 0;

        for (int i = 0; i < relation.length; i++) {
            char check1 = relation[i][0];
            char check2 = relation[i][1];
            if (check1 != check2) {
                symmetric1++;
                for (int j = i; j < relation.length; j++) {
                    char check3 = relation[j][0];
                    char check4 = relation[j][1];
                    if ((check3 == check2) && (check4 == check1)) {
                        symmetric2++;
                    }
                }
            }
        }

        if ((symmetric1 / 2) == symmetric2) {
            return true;
        }
        return false;
    }

    public static boolean isTransitive(char[][] relation, char[] set) {

        char check1 = relation[1][0];
        char check2 = relation[0][1];

        for (int i = 1; i < relation.length - 1; i++) {

            char check3 = relation[i + 1][0];
            char check4 = relation[i + 1][1];

            if (check1 != check2) {
                for (int j = i + 2; j < relation.length-1; j++) {
                    if ((check2 == check3) && (check4 != check1)) {
                        if ((relation[j][0] == check1) && (relation[j][1] == check4)) {
                            return true;
                        }
                    }
                    check3 = relation[j+1][0];
                    check4 = relation[j+1][1];
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isAntiSymmetric(char[][] relation, char[] set) {

        for (int i = 0; i<relation.length;i++){
            char check1 = relation[i][0];
            char check2 = relation[i][1];
            for (int j = 1; j<relation.length;j++){
                char check3 = relation[j][0];
                char check4 = relation[j][1];
                if ((check1!=check2)){
                    if ((check3== check2) &&(check1==check4)) return false;
                }
            }
        }
        return true;
    }

    public static boolean isEquivalenceRelation(char[][] relation, char[] set) {
        if (isReflexive(relation, set)&&isSymmetric(relation, set)&& isTransitive(relation,set)){
            return true;
        }
        return false;
    }

    public static boolean isPartialOrder(char[][] relation, char[] set) {
        if (isReflexive(relation, set)&&isAntiSymmetric(relation, set)&& isTransitive(relation,set)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] setA = {'a', 'x', 'r', 'm', '2', '0'};
        char[][] rel1 = {{'a', 'a'}, {'r', 'a'}, {'a', '2'}, {'x', 'x'}, {'r', '2'}, {'r', 'r'}, {'m', 'm'}, {'2', 'r'}, {'0', '0'}, {'a', 'r'}, {'2', '2'}, {'2', 'a'}};
        char[][] rel2 = {{'a', 'x'}, {'r', '2'}, {'0', '0'}, {'m', '2'}};
        System.out.println("Rel1 is reflexive: " + isReflexive(rel1, setA));
        System.out.println("Rel2 is reflexive: " + isReflexive(rel2, setA));
        System.out.println("Rel1 is symmetric: " + isSymmetric(rel1, setA));
        System.out.println("Rel2 is symmetric: " + isSymmetric(rel2, setA));
        System.out.println("Rel1 is transitive: " + isTransitive(rel1, setA));
        System.out.println("Rel2 is transitive: " + isTransitive(rel2, setA));
        System.out.println("Rel1 is antisymmetric: " + isAntiSymmetric(rel1, setA));
        System.out.println("Rel2 is antisymmetric: " + isAntiSymmetric(rel2, setA));
        System.out.println("Rel1 is an equivalence relation: " + isEquivalenceRelation(rel1, setA));
        System.out.println("Rel2 is an equivalence relation: " + isEquivalenceRelation(rel2, setA));
        System.out.println("Rel1 is a partial order: " + isPartialOrder(rel1, setA));
        System.out.println("Rel2 is a partial order: " + isPartialOrder(rel2, setA));
	/* skal gi følgende utskrift:
	   Rel1 is reflexive: true
	   Rel2 is reflexive: false
	   Rel1 is symmetric: true
	   Rel2 is symmetric: false
	   Rel1 is transitive: true
	   Rel2 is transitive: true
	   Rel1 is antisymmetric: false
	   Rel2 is antisymmetric: true
	   Rel1 is an equivalence relation: true
	   Rel2 is an equivalence relation: false
	   Rel1 is a partial order: false
	   Rel2 is a partial order: false
	 */
    }


}
