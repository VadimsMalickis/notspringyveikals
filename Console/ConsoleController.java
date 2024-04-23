package Console;

public class ConsoleController {
    
    char escCode = 0x1B; 

    public void clearAll(){
        System.out.print("\033[2K\033[1G");
        System.out.flush(); 
    }

    // CHECK IF U CAN HAVE COLLUMNS 

    public void MoveCursor(int row, int column){
        System.out.print(String.format("%c[%d;%df", escCode, row, column));
    }

    public void clearOneLine(int row){
        System.out.print("\033[2K\033[1G");
        System.out.flush(); 
    }

}
