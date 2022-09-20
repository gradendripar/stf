<template>
    <el-container style="height: 100vh;">
        <el-aside :width="isCollapse?'64px':'200px'" style="box-shadow: 2px 0 6px rgb(0 21 41 / 35%);">
            <div class="sidebar-logo-container"
                 style="position: relative;width: 100%;height: 50px;line-height: 40px;text-align: center;">
                <a href="/#/admin/post" class="sidebar-logo-link router-link-active">
<!--                    <span style="float: left;height: 50px;"><img src="../assets/logo.png" width="32" height="32" style="vertical-align: middle;" class="sidebar-logo"></span>-->
                    <span style="float: left;height: 50px;"><h6 class="sidebar-title" style="color: rgb(255, 255, 255);font-weight: 600;vertical-align: center;">某科技论坛</h6></span>
                </a>
            </div>
            <div style="position: relative;height: calc(100vh - 50px);">
                <el-menu default-active="1-4-1" class="el-menu-vertical" :collapse="isCollapse"
                         :collapse-transition="false">
                    <el-menu-item index="1">
                        <i class="el-icon-s-home"></i>
                        <span slot="title">首页</span>
                    </el-menu-item>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-collection"></i>
                            <span slot="title">内容管理</span>
                        </template>
                        <el-menu-item index="2-1">
                            <template slot="title">
                                <i class="el-icon-document"></i>
                                <span slot="title">帖子管理</span>
                            </template>
                        </el-menu-item>
                    </el-submenu>
                </el-menu>
            </div>
        </el-aside>

        <el-container>
            <el-header
                    style="height: 50px;overflow: hidden;position: relative;box-shadow: 0 1px 4px rgb(0 21 41 / 8%);">
                <div id="hamburger-container" class="hamburger-container"
                     style="padding: 0 15px;float: left;line-height: 46px;" @click="toggleClick">
                    <svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" width="20px" height="20px"
                         class="hamburger">
                        <path d="M408 442h480c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8H408c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8zm-8 204c0 4.4 3.6 8 8 8h480c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8H408c-4.4 0-8 3.6-8 8v56zm504-486H120c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8zm0 632H120c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8zM142.4 642.1L298.7 519a8.84 8.84 0 0 0 0-13.9L142.4 381.9c-5.8-4.6-14.4-.5-14.4 6.9v246.3a8.9 8.9 0 0 0 14.4 7z"></path>
                    </svg>
                </div>
                <div style="float: left;display: inline-block;">
                    <el-breadcrumb style="font-size: 14px;line-height: 36px;margin-left: 8px;" separator="/">
                        <el-breadcrumb-item :to="{ path: '/admin/post' }">首页</el-breadcrumb-item>
                        <el-breadcrumb-item :to="{ path: '/admin/post' }">内容管理</el-breadcrumb-item>
                        <el-breadcrumb-item>帖子管理</el-breadcrumb-item>
                    </el-breadcrumb>
                </div>
                <div class="avatar-container right-menu-item hover-effect el-dropdown"
                     style="float: right;margin-right: 25px;">
                    <img src="../assets/avatar.jpg" width="40" height="40" class="user-avatar">
                </div>
                <div style="float: right;line-height: 40px;margin-right: 40px;">
                    <span style="font-size: 15px;margin-right: 20px">{{ todayDateComputed }} {{ todayClockComputed }}</span>
                    <span style="font-size: 16px;margin-right: 10px">您好，测试员！！！ </span>
                </div>
            </el-header>
            <el-main>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    const today = new Date();
    export default {
        name: "Post",
        data() {
            return {
                todayDate: undefined,
                todayClock: undefined,
                isCollapse: false
            }
        },
        computed: {
            todayDateComputed: function () {
                return this.parseTime(today, '{y}年{m}月{d}日')
            },
            todayClockComputed: function () {
                return this.todayClock
            }
        },
        created() {
            this.initDateTime();
            this.getList();
        },
        methods: {
            /** 查询帖子列表 */
            getList() {
                this.getRequest('/post/list').then(response => {
                    console.log(response)
                });
            },
            initDateTime() {
                const that = this;
                setInterval(function () {
                    that.todayClock = that.parseTime(new Date(), '{h}:{i}:{s}')
                }, 1000)
            },
            toggleClick() {
                this.isCollapse = !this.isCollapse;
            }
        }
    }

</script>

<style>
</style>