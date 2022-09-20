import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Post from '../views/Post.vue'

Vue.use(VueRouter);

export const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/admin/post',
    name: 'Post',
    component: Post
  }
];

export default new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
});
