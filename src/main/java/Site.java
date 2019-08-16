public class Site implements Comparable<Site>{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Site o) {
        if (this.name.compareTo(o.name)<0)
        {
            return -1;
        }
        else
        {
            if (this.name.compareTo(o.name)>0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}
