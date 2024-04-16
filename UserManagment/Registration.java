public class Registration {
    public void Register(String username, String email, String name, String surname, String adress, String password){
        User user = new User("alisetoca", "alise.toc@kk.com", "Alise", "Toča", "Valdemāra 7", "gribumajas");
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }
}
