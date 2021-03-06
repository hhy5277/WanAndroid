package com.xujiaji.wanandroid.repository.remote;

import com.xujiaji.wanandroid.repository.bean.BannerBean;
import com.xujiaji.wanandroid.repository.bean.BlogPostBean;
import com.xujiaji.wanandroid.repository.bean.BoxBean;
import com.xujiaji.wanandroid.repository.bean.LicenseBean;
import com.xujiaji.wanandroid.repository.bean.PageBean;
import com.xujiaji.wanandroid.repository.bean.Result;
import com.xujiaji.wanandroid.repository.bean.TreeBean;
import com.xujiaji.wanandroid.repository.bean.UserBean;
import com.xujiaji.wanandroid.repository.bean.VersionBean;
import com.xujiaji.wanandroid.repository.bean.WebNavBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * author: xujiaji
 * created on: 2018/8/5 23:04
 * description:
 */
public interface API {

    /**
     * 首页博文
     */
    @GET("article/list/{num}/json")
    Call<Result<PageBean<BlogPostBean>>> getBlogPosts(@Path("num") int num);

    /**
     * 首页项目
     */
    @GET("article/listproject/{num}/json")
    Call<Result<PageBean<BlogPostBean>>> getProjects(@Path("num") int num);

    /**
     * 首页博文顶部banner图
     */
    @GET("banner/json")
    Call<Result<List<BannerBean>>> getBanners();

    /**
     * 登录
     */
    @POST("user/login")
    @FormUrlEncoded
    Call<Result<UserBean>> postLogin(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     */
    @POST("user/register")
    @FormUrlEncoded
    Call<Result<UserBean>> postRegister(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 收藏文章
     */
    @POST("lg/collect/{id}/json")
    Call<Result<String>> postCollect(@Path("id") int id);

    /**
     * 取消收藏文章
     */
    @POST("lg/uncollect_originId/{id}/json")
    Call<Result<String>> postUncollect(@Path("id") int id);

    /**
     * 收藏
     */
    @GET("lg/collect/list/{num}/json")
    Call<Result<PageBean<BlogPostBean>>> getCollects(@Path("num") int num);

    /**
     * 公开的API
     */
    @GET("openapis")
    Call<String> getOpenAPIS();

    /**
     * 获取插件列表信息
     */
    @GET
    Call<Result<List<BoxBean>>> getBoxes(@Url String url);

    /**
     * 体系
     */
    @GET("tree/json")
    Call<Result<List<TreeBean>>> getPostTree();

    /**
     * 网站导航
     */
    @GET("navi/json")
    Call<Result<List<WebNavBean>>> getWebNavs();

    /**
     * 项目分类列表
     */
    @GET("project/tree/json")
    Call<Result<List<TreeBean>>> getProjectTree();

    /**
     * 获取友链html页面
     */
    @GET("ulink")
    Call<String> getFriendLinks();

    /**
     *  获取项目中使用的开源库信息
     */
    @GET
    Call<Result<List<LicenseBean>>> getLicenses(@Url String url);

    /**
     * 获取更新版本信息
     */
    @GET
    Call<Result<VersionBean>> getUpdateVersion(@Url String url);

    /**
     * 获取知识体系详情列表
     */
    @GET("article/list/{num}/json")
    Call<Result<PageBean<BlogPostBean>>> getPostTreeDetailList(@Path("num") int page, @Query("cid") int id);

}
