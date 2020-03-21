package dao;

public class Project {
    //项目名字
    private String name;
    //项目主页链接, 对应到a标签中的 href 属性
    private String url;
    //项目的描述信息, 对应到li标签里面的内容
    private String description;

    //以下属性是我们需要统计到的数据
    // 需要根据该项目的url进入到对应页面,从页面上获取到刚才的几个属性
    private int starCount;
    private int forkCount;
    private int openIssueCount;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public int getStarCount() {
        return starCount;
    }

    public int getForkCount() {
        return forkCount;
    }

    public int getOpenIssueCount() {
        return openIssueCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void setForkCount(int forkCount) {
        this.forkCount = forkCount;
    }

    public void setOpenIssueCount(int openIssueCount) {
        this.openIssueCount = openIssueCount;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", statCount=" + starCount +
                ", forkCount=" + forkCount +
                ", openIssueCount=" + openIssueCount +
                '}';
    }
}
