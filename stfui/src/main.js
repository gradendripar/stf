import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import {deleteRequest, getRequest, postRequest, putRequest} from "./api/login";
import {parseTime,resetForm} from "./utils/common"

Vue.config.productionTip = false;

Vue.use(ElementUI);

Vue.prototype.postRequest = postRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.parseTime = parseTime;
Vue.prototype.resetForm = resetForm;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app');
