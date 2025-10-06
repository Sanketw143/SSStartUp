package org.ssupstart.datastructure.twopointeralgo.leetcodes.boatstosave881;


import java.util.Arrays;

//You are given an array people where people[i] is the weight of the ith person,
// and an infinite number of boats where each boat can carry a maximum weight of limit.
// Each boat carries at most two people at the same time,
// provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.
//Example 1:
//
//Input: people = [1,2], limit = 3
//Output: 1
//Explanation: 1 boat (1, 2)
//Example 2:
//
//Input: people = [2,2,3,1], limit = 3
//1,2,2,3
//Output: 3
//Explanation: 3 boats (1, 2), (2) and (3)
//Example 3:
//
//Input: people = [3,5,3,4], limit = 5
//Output: 4
//Explanation: 4 boats (3), (3), (4), (5)
public class BoatsToSavePeople881V2 {
    public static void main(String[] args) {
        int[] persons = {3,5,3,4};
        //3,3,4,5
        //3 4

        int limit = 5;
        int numberOfBoats = getMaximumNumberOfBoats(persons, limit);
    }


    //Input: people = [2,2,3,1], limit = 3
    //1,2,2,3
    //s     e
    //1,2,2,3
    //s   e
    //Output: 3
    //Explanation: 3 boats (1, 2), (2) and (3)
    private static int getMaximumNumberOfBoats(int[] persons, int limit) {
        Arrays.sort(persons);
        int firstPerson = 0;
        int secondPerson = persons.length-1;
        int numberOfBoats = 0;

        while(firstPerson <= secondPerson) {
            numberOfBoats++;
            if(persons[firstPerson] + persons[secondPerson] <= limit) {
                firstPerson++;
            }
            secondPerson--;
        }
        return numberOfBoats;
    }
}
