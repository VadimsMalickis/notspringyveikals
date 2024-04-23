package Console;

public class ConsoleController {
    
    char escCode = 0x1B; 

    public void MoveCursor(int row, int column){
        System.out.print(String.format("%c[%d;%df", escCode, row, column));
    }
}
