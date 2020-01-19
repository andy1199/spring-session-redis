package sessionDemo;

import java.io.Serializable;

public class User implements Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = -5654418863461227475L;
    private String username;
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public User(String username, String age)
    {
        super();
        this.username = username;
        this.password = age;
    }

}
