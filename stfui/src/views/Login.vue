<template>
    <div>
        <el-form :rules="rules" ref="loginForm" :model="loginForm" class="login-form">
            <h3 class="title">系统登录</h3>
            <el-form-item prop="username">
                <el-input type="text" auto-complete="false" v-model="loginForm.username"
                          placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" auto-complete="false" v-model="loginForm.password"
                          placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item prop="code">
                <img :src="captchaUrl" @click="updatedCaptcha">
                <el-input type="text" auto-complete="false" v-model="loginForm.code" placeholder="点击图片更换验证码"
                          style="width: 250px;"></el-input>
            </el-form-item>
            <el-form-item>
                <el-checkbox v-model="checked">记住我</el-checkbox>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="width: 100%" @click="submitLoginForm">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                captchaUrl: '/captcha?time=' + new Date(),
                loginForm: {
                    username: 'admin',
                    password: '123456',
                    code: ''
                },
                checked: true,
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'}],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}],
                    code: [
                        {required: true, message: '请输入验证码', trigger: 'blur'}],
                }
            }
        },
        methods: {
            submitLoginForm() {
                this.$refs.loginForm.validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        this.$message.error('请输入必填的字段！！！');
                        return false;
                    }
                });
            },
            updatedCaptcha() {
                this.captchaUrl = '/captcha?time='+new Date();
            }
        },
    }
</script>

<style>
    .login-form {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 150px auto;
        width: 350px;
        padding: 15px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }

    .title {
        text-align: center;
    }

    .el-form-item__content{
        display: flex;
        align-items: center;
    }
</style>