package cn.et.works.utils;

import java.util.List;

public class PageTools {
    /**
     * 
     * 
     * @param curPage   ҳ�洫��ĵ�ǰҳ
     * @param totalCount   ���ݿ��ѯ���ܼ�¼��
     * @param pageCount     ÿҳ��ʾ������
     */
    public PageTools(Integer curPage,Integer totalCount,Integer pageCount){
        this.curPage=curPage;
        this.total=totalCount;
        this.pageCount=pageCount==null?this.pageCount:pageCount;
        //��һҳ
        this.prePage=(curPage==1?1:curPage-1);
        //��ҳ��
        this.totalPage=totalCount%this.pageCount==0?totalCount/this.pageCount:(totalCount/this.pageCount+1);
        //��һҳ
        this.nextPage=(curPage==totalPage)?totalPage:(curPage+1);
        //���ݿ�ڼ�ҳÿҳ��ʾ������   ��ʼ�����ͽ�������
        this.startIndex=(curPage-1)*this.pageCount+1;
        this.endIndex=curPage*this.pageCount;
    }
    
    
    
    /**
     * ��ǰҳ(��̬  ��ҳ�洫��)
     */
    private Integer curPage;
    /**
     * ��һҳ
     * prePage=(curPage==1?1:curPage-1)
     * 
     */
    private Integer prePage;
    /**
     * ��һҳ
     * nextPage=(nextPage==totalPage)?totalPage:(curPage+1)
     * 
     * 
     */
    private Integer nextPage;
    //ÿҳ��ʾ������
    private Integer pageCount=10;
    /**
     * ��ҳ��
     * totalPage=(totalCount%pageCount==0?totalCount/pageCount:(totalCount/pageCount+1)
     * 
     */
    private Integer totalPage;
    //���ݿ���ܼ�¼��(���ݿ��ѯ)
    private Integer total;
    //ÿҳ�����ݷ���ü�����
    private List rows;
    
    /**
     * ���ݿ⿪ʼ�����ͽ�������
     * 
     * startIndex=(curPage-1)*PageCount+1
     * endIndex=curPage*pageCount
     * 
     */
    private int startIndex;
    private int endIndex;
    
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public int getEndIndex() {
        return endIndex;
    }
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
    public Integer getCurPage() {
        return curPage;
    }
    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }
    public Integer getPrePage() {
        return prePage;
    }
    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }
    public Integer getNextPage() {
        return nextPage;
    }
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotalt(Integer total) {
        this.total = total;
    }
    
    
    public static void main(String[] args) {
        int curPage=6;
        int totalCount=27;
        int pageCount=5;
        
        PageTools pt=new PageTools(curPage, totalCount, pageCount);
        System.out.println(pt.getNextPage());
        System.out.println(pt.getPrePage());
        System.out.println(pt.getTotalPage());
        System.out.println(pt.getStartIndex());
        System.out.println(pt.getEndIndex());
    }
}