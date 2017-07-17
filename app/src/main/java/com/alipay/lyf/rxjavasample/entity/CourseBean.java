package com.alipay.lyf.rxjavasample.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by CJ on 2016/12/26.
 */

public class CourseBean implements Serializable {

    /**
     * cwid : 1 agreenum : 1 isown : 1 createtime : 2016-12-18 13:16 ccrFee : 0.00 fee : 0 ccatname : 好好学习 cmmtnum : 6
     * tchname : 神 ccrid : 1 vodInfo : [{"duration":306,"creator":1,"createtime":"2016-12-21",
     * "vodFiles":[{"imgurl":"http://vodwbil74qz.nosdn.127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg",
     * "size":160137724,"vvfid":1,"downloadurl":"http://vodwbil74qz.nosdn.127
     * .net/4dcc6195-927a-4201-b05d-58063114a29e.mp4?download=大启学堂
     * 学员篇.mp4.mp4","type":1, "playurl":"http://vodwbil74qz.vod.126
     * .net/vodwbil74qz/4dcc6195-927a-4201-b05d-58063114a29e.mp4"},
     * {"imgurl":"http://vodwbil74qz.nosdn.127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg",
     * "size":18579962,"vvfid":2,"downloadurl":"http://vodwbil74qz.nosdn.127.net/mp4/sGa56qjF_408279_sd
     * .mp4?download=流畅_大启学堂 学员篇.mp4.mp4","type":2,"playurl":"http://vodwbil74qz.vod.126
     * .net/vodwbil74qz/mp4/sGa56qjF_408279_sd.mp4"},{"imgurl":"http://vodwbil74qz.nosdn.127
     * .net/963c3251-b25c-4b57-b857-733bd4240074.jpg","size":35321670,"vvfid":3, "downloadurl":"http://vodwbil74qz
     * .nosdn.127.net/mp4/ZAhURB6U_408279_hd.mp4?download=标清_大启学堂
     * 学员篇.mp4 .mp4","type":3,"playurl":"http://vodwbil74qz.vod.126.net/vodwbil74qz/mp4/ZAhURB6U_408279_hd.mp4"},
     * {"imgurl":"http://vodwbil74qz.nosdn.127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg",
     * "size":61853826,"vvfid":4,"downloadurl":"http://vodwbil74qz.nosdn.127.net/mp4/sGa56qjF_408279_sd
     * .mp4?download=流畅_大启学堂 学员篇.mp4.mp4","type":4,"playurl":"http://vodwbil74qz.vod.126
     * .net/vodwbil74qz/mp4/sAExxCqs_408279_shd.mp4"}],"extraurl":"http://vodwbil74qz.nosdn.127
     * .net/963c3251-b25c-4b57-b857-733bd4240074.jpg","name":"大启学堂 学员篇.mp4","extraVid":"408279","sort":1, "vvid":4}]
     * intro : 你是祖国的花骨朵 tchintro : 小伙子，不错哟 name : 好好学习，天天向上 clicknum : 43 viptype : 1 ccrstatus : 2 ccatid : 1 status :
     * 2 primaryimg: string, 课件导读图 compressimg: string, 压缩导读图
     */

    private String primaryimg;
    /**
     * fee : 0.9 rslviid : 253
     */

    private int rslviid;

    public String getCompressimg() {
        return compressimg;
    }

    public void setCompressimg(String compressimg) {
        this.compressimg = compressimg;
    }

    public String getPrimaryimg() {
        return primaryimg;
    }

    public void setPrimaryimg(String primaryimg) {
        this.primaryimg = primaryimg;
    }

    private String compressimg;
    private int cwid;
    private int agreenum;
    private int isown;
    private String createtime;
    private double ccrFee;
    private double fee;
    private String ccatname;
    private int cmmtnum;
    private String tchname;
    private int ccrid;
    private String intro;
    private String tchintro;
    private String name;
    private int clicknum;
    private Integer viptype;
    private int ccrstatus;
    private int ccatid;
    private int status;


    private int collectnum;
    private String tchheadimg;
    private int tchid;
    private String shareUrl;
    private String tchcompressurl;

    /**
     * isBought : 0 iscollect : 0 isagree : 1
     */

    private int isBought;
    private int iscollect;
    private int isagree;

    private boolean head;
    private boolean recommend;

    private boolean selected;

    public int getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(int collectnum) {
        this.collectnum = collectnum;
    }


    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    private List<Label> labels;

    public String getTchheadimg() {
        return tchheadimg;
    }

    public void setTchheadimg(String tchheadimg) {
        this.tchheadimg = tchheadimg;
    }

    public String getTchcompressurl() {
        return tchcompressurl;
    }

    public void setTchcompressurl(String tchcompressurl) {
        this.tchcompressurl = tchcompressurl;
    }

    public int getTchid() {
        return tchid;
    }

    public void setTchid(int tchid) {
        this.tchid = tchid;
    }

    /**
     * duration : 306 creator : 1 createtime : 2016-12-21 vodFiles : [{"imgurl":"http://vodwbil74qz.nosdn
     * .127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg", "size":160137724,"vvfid":1,
     * "downloadurl":"http://vodwbil74qz.nosdn.127
     * .net/4dcc6195-927a-4201-b05d-58063114a29e.mp4?download=大启学堂 学员篇.mp4.mp4","type":1,
     * "playurl":"http://vodwbil74qz.vod.126.net/vodwbil74qz/4dcc6195-927a-4201-b05d-58063114a29e.mp4"},
     * {"imgurl":"http://vodwbil74qz.nosdn.127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg",
     * "size":18579962,"vvfid":2,"downloadurl":"http://vodwbil74qz.nosdn.127.net/mp4/sGa56qjF_408279_sd
     * .mp4?download=流畅_大启学堂 学员篇.mp4.mp4","type":2,"playurl":"http://vodwbil74qz.vod.126
     * .net/vodwbil74qz/mp4/sGa56qjF_408279_sd.mp4"},{"imgurl":"http://vodwbil74qz.nosdn.127
     * .net/963c3251-b25c-4b57-b857-733bd4240074.jpg","size":35321670,"vvfid":3, "downloadurl":"http://vodwbil74qz
     * .nosdn.127.net/mp4/ZAhURB6U_408279_hd.mp4?download=标清_大启学堂
     * 学员篇.mp4 .mp4","type":3,"playurl":"http://vodwbil74qz.vod.126.net/vodwbil74qz/mp4/ZAhURB6U_408279_hd.mp4"},
     * {"imgurl":"http://vodwbil74qz.nosdn.127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg",
     * "size":61853826,"vvfid":4,"downloadurl":"http://vodwbil74qz.nosdn.127.net/mp4/sGa56qjF_408279_sd
     * .mp4?download=流畅_大启学堂 学员篇.mp4.mp4","type":4,"playurl":"http://vodwbil74qz.vod.126
     * .net/vodwbil74qz/mp4/sAExxCqs_408279_shd.mp4"}] extraurl : http://vodwbil74qz.nosdn.127
     * .net/963c3251-b25c-4b57-b857-733bd4240074.jpg name : 大启学堂 学员篇.mp4 extraVid : 408279 sort : 1 vvid : 4
     */

    private List<VodInfoBean> vodInfo;

    public int getCwid() {
        return cwid;
    }

    public void setCwid(int cwid) {
        this.cwid = cwid;
    }

    public int getAgreenum() {
        return agreenum;
    }

    public void setAgreenum(int agreenum) {
        this.agreenum = agreenum;
    }

    public int getIsown() {
        return isown;
    }

    public void setIsown(int isown) {
        this.isown = isown;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public double getCcrFee() {
        return ccrFee;
    }

    public void setCcrFee(double ccrFee) {
        this.ccrFee = ccrFee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getCcatname() {
        return ccatname;
    }

    public void setCcatname(String ccatname) {
        this.ccatname = ccatname;
    }

    public int getCmmtnum() {
        return cmmtnum;
    }

    public void setCmmtnum(int cmmtnum) {
        this.cmmtnum = cmmtnum;
    }

    public String getTchname() {
        return tchname;
    }

    public void setTchname(String tchname) {
        this.tchname = tchname;
    }

    public int getCcrid() {
        return ccrid;
    }

    public void setCcrid(int ccrid) {
        this.ccrid = ccrid;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTchintro() {
        return tchintro;
    }

    public void setTchintro(String tchintro) {
        this.tchintro = tchintro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClicknum() {
        return clicknum;
    }

    public void setClicknum(int clicknum) {
        this.clicknum = clicknum;
    }

    public Integer getViptype() {
        return viptype;
    }

    public void setViptype(Integer viptype) {
        this.viptype = viptype;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getCcrstatus() {
        return ccrstatus;
    }

    public void setCcrstatus(int ccrstatus) {
        this.ccrstatus = ccrstatus;
    }

    public int getCcatid() {
        return ccatid;
    }

    public void setCcatid(int ccatid) {
        this.ccatid = ccatid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<VodInfoBean> getVodInfo() {
        return vodInfo;
    }

    public void setVodInfo(List<VodInfoBean> vodInfo) {
        this.vodInfo = vodInfo;
    }

    public int getIsBought() {
        return isBought;
    }

    public void setIsBought(int isBought) {
        this.isBought = isBought;
    }

    public int getIscollect() {
        return iscollect;
    }

    public void setIscollect(int iscollect) {
        this.iscollect = iscollect;
    }

    public int getIsagree() {
        return isagree;
    }

    public void setIsagree(int isagree) {
        this.isagree = isagree;
    }

    public void changeAgreeStatus() {
        this.isagree = isagree == 0 ? 1 : 0;
    }

    public int getRslviid() {
        return rslviid;
    }

    public void setRslviid(int rslviid) {
        this.rslviid = rslviid;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public boolean hasCollect() {
        return iscollect == 1;
    }

    public boolean hasAgree() {
        return isagree == 1;
    }

    public boolean needPay(boolean isVIP) {

        if (fee == 0) {//免费
            return false;
        }

        if (isBought == 1) {//已购买
            return false;
        }

        if (viptype != null && viptype == 1) {//免费观看
            return false;
        }

        //vip免费
        if (isVIP/* && viptype == 2*/) {
            return false;
        }
        return true;
    }


    public boolean isHead() {
        return head;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }


    public void changeSelectStatus() {
        selected = !selected;
    }

    public void changeCollectStatus() {
        this.iscollect = iscollect == 0 ? 1 : 0;
    }

    public static class VodInfoBean implements Serializable {
        private int duration;
        private int creator;
        private String createtime;
        private String extraurl;
        private String name;
        private String extraVid;
        private int sort;
        private int vvid;
        private boolean play;
        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean isPlay() {
            return play;
        }

        public void setPlay(boolean play) {
            this.play = play;
        }

        /**
         * imgurl : http://vodwbil74qz.nosdn.127.net/963c3251-b25c-4b57-b857-733bd4240074.jpg size : 160137724 vvfid : 1
         * downloadurl : http://vodwbil74qz.nosdn.127.net/4dcc6195-927a-4201-b05d-58063114a29e .mp4?download=大启学堂
         * 学员篇.mp4.mp4 type : 1 playurl : http://vodwbil74qz.vod.126
         * .net/vodwbil74qz/4dcc6195-927a-4201-b05d-58063114a29e.mp4
         */


        private List<VodFilesBean> vodFiles;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getCreator() {
            return creator;
        }

        public void setCreator(int creator) {
            this.creator = creator;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getExtraurl() {
            return extraurl;
        }

        public void setExtraurl(String extraurl) {
            this.extraurl = extraurl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExtraVid() {
            return extraVid;
        }

        public void setExtraVid(String extraVid) {
            this.extraVid = extraVid;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getVvid() {
            return vvid;
        }

        public void setVvid(int vvid) {
            this.vvid = vvid;
        }

        public List<VodFilesBean> getVodFiles() {
            return vodFiles;
        }

        public void setVodFiles(List<VodFilesBean> vodFiles) {
            this.vodFiles = vodFiles;
        }

        public static class VodFilesBean implements Serializable {
            private String imgurl;
            private int size;
            private int vvfid;
            private String downloadurl;
            private int type;
            private String playurl;

            public String getImgurl() {
                return imgurl;
            }

            public void setImgurl(String imgurl) {
                this.imgurl = imgurl;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVvfid() {
                return vvfid;
            }

            public void setVvfid(int vvfid) {
                this.vvfid = vvfid;
            }

            public String getDownloadurl() {
                return downloadurl;
            }

            public void setDownloadurl(String downloadurl) {
                this.downloadurl = downloadurl;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getPlayurl() {
                return playurl;
            }

            public void setPlayurl(String playurl) {
                this.playurl = playurl;
            }
        }
    }
}
