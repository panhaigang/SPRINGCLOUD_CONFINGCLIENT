package cn.et.works.entity;

public class Dept1 {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept1.id
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept1.dname
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    private String dname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept1.pid
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    private Integer pid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept1.id
     *
     * @return the value of dept1.id
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept1.id
     *
     * @param id the value for dept1.id
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept1.dname
     *
     * @return the value of dept1.dname
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    public String getDname() {
        return dname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept1.dname
     *
     * @param dname the value for dept1.dname
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept1.pid
     *
     * @return the value of dept1.pid
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept1.pid
     *
     * @param pid the value for dept1.pid
     *
     * @mbg.generated Tue Dec 12 20:48:24 CST 2017
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}