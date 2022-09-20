<template>
  <el-container>
    <el-aside>
      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
        <el-radio-button :label="false">展开</el-radio-button>
        <el-radio-button :label="true">收起</el-radio-button>
      </el-radio-group>
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
               :collapse="isCollapse">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span slot="title">内容管理</span>
          </template>
          <el-menu-item index="1-1">帖子管理</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-header>
      <el-row>
        <el-col :span="6">
          <div>
            <svg data-v-49e15297="" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" width="64" height="64"
                 class="hamburger">
              <path data-v-49e15297=""
                    d="M408 442h480c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8H408c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8zm-8 204c0 4.4 3.6 8 8 8h480c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8H408c-4.4 0-8 3.6-8 8v56zm504-486H120c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8zm0 632H120c-4.4 0-8 3.6-8 8v56c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-56c0-4.4-3.6-8-8-8zM142.4 642.1L298.7 519a8.84 8.84 0 0 0 0-13.9L142.4 381.9c-5.8-4.6-14.4-.5-14.4 6.9v246.3a8.9 8.9 0 0 0 14.4 7z"></path>
            </svg>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/admin/post' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>内容管理</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/admin/post' }">帖子管理</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
        </el-col>
        <el-col :span="6">
          <div>
            <span style="font-size: 14px;margin-right: 20px">{{ todayDateComputed }} {{ todayClockComputed }}</span>
            <span style="font-size: 16px;margin-right: 10px">您好，测试员！！！ </span>
          </div>
        </el-col>
        <el-col :span="6">
          <div></div>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch"
               label-width="68px">
        <el-form-item label="帖子标题" prop="title">
          <el-input
              v-model="queryParams.title"
              placeholder="帖子标题"
              clearable
              @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item label="帖子发表时间">
          <el-date-picker
              v-model="daterangeStartTime"
              style="width: 240px"
              value-format="yyyy-MM-dd"
              type="daterange"
              range-separator="-"
              start-placeholder="开始日期"
              end-placeholder="结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>

      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
          <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
          >新增
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
              type="success"
              plain
              icon="el-icon-edit"
              size="mini"
              :disabled="single"
              @click="handleUpdate"
          >修改
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button
              type="danger"
              plain
              icon="el-icon-delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
          >删除
          </el-button>
        </el-col>
      </el-row>

      <el-table v-loading="loading" :data="postList" fit @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"/>
        <el-table-column label="帖子标题" align="center" prop="title"/>
        <el-table-column label="帖子作者" align="center" prop="author"/>
        <el-table-column label="帖子内容" align="center" prop="content"/>
        <el-table-column label="帖子所属栏目" align="center" prop="slug"/>
        <el-table-column label="帖子标签" align="center" prop="tag"/>

        <el-table-column label="帖子发表时间" align="center" prop="created" width="180">
<!--          <template slot-scope="scope">-->
<!--            <span>{{ parseTime(scope.row.created, '{y}-{m}-{d} {h}:{m}:{s}') }}</span>-->
<!--          </template>-->
        </el-table-column>
        <el-table-column label="帖子关闭状态" align="center" prop="open_status"/>
        <el-table-column label="帖子审核状态" align="center" prop="verify_status">
          <!--        <template slot-scope="scope">-->
          <!--          <dict-tag :options="dict.type.sys_notice_status" :value="scope.row.status"/>-->
          <!--        </template>-->
        </el-table-column>
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
            >修改
            </el-button>
            <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
            >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 添加或修改活动信息对话框 -->
      <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item label="帖子标题" prop="title">
            <el-input v-model="form.title" placeholder="请输入帖子标题"/>
          </el-form-item>
          <el-form-item label="帖子作者" prop="author">
            <el-input v-model="form.author" placeholder="请输入帖子作者"/>
          </el-form-item>
          <el-form-item label="帖子内容" prop="content">
            <el-input v-model="form.content" placeholder="请输入帖子内容"/>
          </el-form-item>
          <el-form-item label="帖子所属栏目" prop="slug">
            <el-input v-model="form.slug" placeholder="请输入帖子所属栏目"/>
          </el-form-item>
          <el-form-item label="帖子标签" prop="tag">
            <el-input v-model="form.tag" placeholder="请输入帖子标签"/>
          </el-form-item>
          <el-form-item label="帖子发表时间" prop="created">
            <el-date-picker clearable
                            v-model="form.created"
                            type="datetime"
                            format="yyyy-MM-dd HH:mm:ss"
                            value-format="yyyy-MM-dd HH:mm:ss"
                            placeholder="请选择帖子发表时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="帖子关闭状态" prop="open_status">
            <el-input v-model="form.open_status" placeholder="请输入帖子关闭状态"/>
          </el-form-item>
          <el-form-item label="帖子审核状态" prop="verify_status">
            <el-input v-model="form.verify_status" placeholder="请输入帖子审核状态"/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </el-dialog>
    </el-main>
  </el-container>
</template>

<script>

import {parseTime} from '@/utils/common';

const today = new Date();
export default {
  name: "Post",
  data() {
    return {
      todayDate: undefined,
      todayClock: undefined,
      isCollapse: true,
      loading: true,
      // 选中数组
      ids: [],
      single: true,
      multiple: true,
      showSearch: true,
      postList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 日期范围
      daterangeStartTime: [],
      // 查询参数
      queryParams: {
        title: null,
        created: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          {required: true, message: "帖子标题不能为空", trigger: "blur"}
        ],
        author: [
          {required: true, message: "帖子作者不能为空", trigger: "blur"}
        ],
        content: [
          {required: true, message: "帖子内容不能为空", trigger: "blur"}
        ],
        slug: [
          {required: true, message: "帖子所属栏目不能为空", trigger: "blur"}
        ],
        tag: [
          {required: true, message: "帖子标签不能为空", trigger: "blur"}
        ],
        created: [
          {required: true, message: "帖子发表时间不能为空", trigger: "blur"}
        ]
      }
    }
  },
  computed: {
    todayDateComputed: function () {
      return parseTime(today, '{y}年{m}月{d}日')
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
    initDateTime() {
      const that = this;
      setInterval(function () {
        that.todayClock = parseTime(new Date(), '{h}:{i}:{s}')
      }, 1000)
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    /** 查询帖子列表 */
    getList() {
      this.loading = true;
      this.getRequest('/post/list').then(response => {
        this.postList = response.data;
        this.loading = false;
        console.log(this.postList);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        title: null,
        author: null,
        content: null,
        slug: null,
        tag: null,
        created: null,
        open_status: "1",
        verify_status: "0"
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeStartTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getActivity(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改活动信息";
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除活动信息编号为"' + ids + '"的数据项？').then(function () {
        return delActivity(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateActivity(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActivity(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
  }
}

</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
}
</style>