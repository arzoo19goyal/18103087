class casting{
    public static void main(String args[])
    {
        int initialValue = -1;
        byte intToByte = (byte) initialValue;
        char byteToChar = (char) intToByte;
        int finalValue = (int) byteToChar;

        System.out.println("Initial integer: " + initialValue);   // -1
        System.out.println("Value casted from int to byte: " + intToByte);  // -1
        System.out.println("Value casted from byte to char: " + byteToChar);   // ￿ (rectangle character)
        System.out.println("Final integer: " + finalValue);  // 65535

    }
}

/* explanation */
/*
int type casted to byte: byte datatype is 8 bit number of range -128 to +127. So, -1 can be easily stored.

byte type casted to char: The char datatype is 16 bit Unicode character. It has a minimum value of '\u0000' and a maximum of '\uffff'.

char type casted to int: Finally the char is type casted to integer value. int is of 32 bits and char is 16 bit. So, final integer = 2^16 - 1.
*/
