# HugeInteger-doubly-linked-list

Description: I will create a class called “HugeInteger” that stores and allows operations on huge integers. The class HugeInteger stores the digits of the number in a doubly linked list in reverse order (i.e the least significant digit is the first item, most significant digit is the last).
For example the number “87543637” would be stored in reverse order as shown below.

![image](https://user-images.githubusercontent.com/15815335/74581128-bedccd00-4f79-11ea-9846-391b37244f1a.png)

**State variables**
* isPositive:	Stores the sign of the number (positive or negative) as a boolean state value 
* head:	Stores the first Node of the linked list (It is null if the list is empty).
* tail:	Stores or keeps track of the last item in the list (It is null if the list is empty).
* length:	Stores the number of digits in the number (excluding the sign)

**Constructors**
* **Public HugeInteger():**	An empty linked list is created. That is: isPositive must be set to true by default. Head and tail are set to null. If this variable is to be displayed,  a “0” should be printed (the zero is not stored). Length must be set to 0;
* **Public HugeInteger(String number):**	Creates the number from the string with all leading zeros (0) removed.
 Constructors

**Additional Behaviour**
* **HugeInteger addPositive(HugeInteger num2):**	Returns a new HugeInteger containing the result of adding num2 to the stored number. Assumption: num2 and the number being added to are BOTH positive.
* **int compareTo (HugeInteger num2):**	Returns -1 if the number stored is less than num2
Returns 0 if the number stored is equal to num2
Returns 1 if the number stored is greater than num2
* **String toString():**	Returns a string representation of the number
* **void concatenateDigit(int digit):**	Adds a digit to the end of the number (at the front of the list). Note: if the list is empty leading zeros should not be added.
* **void addLast(int digit):**	Adds a digit to the front of the number (at the end of the list). This can be used in the addPositive method
