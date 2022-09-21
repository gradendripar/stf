import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

export const routes = [
    {
        path: '/',
        name: 'Login',
        component: () => import('@/views/Login'),
        meta: {
            title: '登录页面'
        }
    },
    {
        path: '/admin/post',
        name: 'Post',
        component: () => import('@/views/Post'),
        meta: {
            title: '帖子管理'
        }
    }
];

export default new VueRouter({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes
});
