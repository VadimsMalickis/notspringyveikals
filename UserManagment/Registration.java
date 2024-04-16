public class Registration {
    
    public void Register(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }
}
