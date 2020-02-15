// Author: Kamrun Nahar Liza
// Student ID: 101200678

package com.company;

public class HugeInteger {
    Node head, tail;
    boolean isPositive = true;
    int length = 0;

    public HugeInteger() {
        head = tail = null;
        length = 0;
    }

    public HugeInteger(String number) {
        if(number.charAt(0) == '-') {
            number = number.substring(1); //trimmed sign, storing only digits in Linked List
            isPositive = false;
        }
        number = number.replaceFirst("^0+(?!$)", ""); // remove leading zeros

        for(int i = number.length() - 1; i >= 0; i--)
        {
            addLast(Character.getNumericValue(number.charAt(i)));
        }
    }

    // Adds a digit to the end of the number, front of the list
    public void concatenateDigit(int digit) {
        Node n = new Node(digit);
        if (head == null){ //if list is empty
            head = tail = n;
        } else {
            head.prev = n; // If list is not empty
            n.next = head;
            head = n; // n is the new head
        }
        length++;
    }

    // Adds a digit at the end of the list
    public void addLast(int digit){
        Node n = new Node(digit);
        if(tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        length++;
    }

    // Assumption: both the numbers are positive
    public HugeInteger addPositive(HugeInteger num2) {
        HugeInteger resultantHI = new HugeInteger();
        Node curr = head;
        Node currHeadNum2 = num2.head;
        int carry = 0, sum;

        while (curr != null || currHeadNum2 != null)
        {
            // Calculating the value of next digit in resultant
            // The next digit is the sum of Carry + Next digit of first list
            // + Next digit of second list
            sum = carry + (curr != null ? curr.data : 0)
                    + (currHeadNum2 != null ? currHeadNum2.data : 0);

            // update carry for next calculation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Add sum to resultant list
            resultantHI.addLast(sum);

            // Move first and second pointers to next nodes
            if (curr != null) {
                curr = curr.next;
            }
            if (currHeadNum2 != null) {
                currHeadNum2 = currHeadNum2.next;
            }
        }
        if (carry > 0) {
            resultantHI.addLast(carry);
        }
        return resultantHI;
    }

    //Returns -1 if the number stored is less than num2
    //Returns 0 if the number stored is equal to num2
    //Returns 1 if the number stored is greater than num2
    public int compareTo (HugeInteger num2) {
        Node curr = this.tail;
        Node curr2 = num2.tail;
        if(this.isPositive ^ num2.isPositive) { //numbers has opposite sign
            return this.isPositive ? 1: -1;
        } else { //both positive or both negative
            if(this.length == num2.length) { // Equal length
                while (curr.prev != null && curr2.prev != null && curr.data == curr2.data) {
                    curr = curr.prev;
                    curr2 = curr2.next;
                }
                if(curr.data > curr2.data) {
                    if(this.isPositive) return 1;
                    return -1;
                }
                return 0;
            } else { // Different length
                if(this.isPositive) {
                    return this.length > num2.length ? 1: -1;
                } else { //both negative && of different length
                    return this.length > num2.length ? -1: 1;
                }
            }
        }
    }

    public String toString() {
        String s = "";
        if(!isPositive) s += "-";

        Node curr = head;
        if(head == null) {
            s = "0";
            return s;
        }
        s += ReversePrint(head);
        return s;
    }

    private String ReversePrint(Node head) {
        String s = "";
        if(head != null) {
            s += ReversePrint(head.next);
            s += head.data;
        }
        return s;
    }
}
