public class Menu {
    String[]        option;
    String          prefix;

    public                          Menu(String[] option)
    {
        this.option = option;
        this.prefix = "";
    }

    public                          Menu(String[] option, String prefix)
    {
        this.option = option;
        this.prefix = prefix;
    }

    public String[]                 getOption() {
        return option;
    }

    public void                     setOption(String[] option) {
        this.option = option;
    }

    public void                     addOption(String s)
    {
        String[]    opt;
        int         len;

        len = option.length;
        opt = new String[len + 1];
        opt[len] = s;
        option = opt;
    }

    public static float              askRealNumber(String prompt)
    {
        float       ret;

        while (true)
        {
            try
            {
                ret = Terminal.lireFloat(prompt);
                return (ret);
            } catch (TerminalException e) {
                Terminal.ecrireStringln("Entrez un nombre valide!");
            }
        }
    }

    public static int              askNumber(String prompt)
    {
        int         ret;

        while (true)
        {
            try
            {
                ret = Terminal.lireInt(prompt);
                return (ret);
            } catch (TerminalException e) {
                Terminal.ecrireStringln("Entrez un nombre valide!");
            }
        }
    }

    private static String           askString(String prompt)
    {
        String      s;

        s = "";
        while (s.length() == 0)
            s = Terminal.lireString(prompt + ": ").trim();
        return (s);
    }

    public String                   toString()
    {
        String      out;

        if (option == null)
            return ("");
        out = "";
        if (!prefix.equals(""))
            out += prefix + "\n";
        for (int i = 0; i < option.length; i++)
            out += "(" + i + ") -> " + option[i].substring(0, 1).toUpperCase() + option[i].substring(1) + "\n";
        return (out);
    }

    public int                      ask()
    {
        String      input;

        input = askString(toString()).toLowerCase();
        for (char i = 0; i < option.length; i++)
            if (input.equals(option[i]))
                return (i);
        return (ask());
    }
}
