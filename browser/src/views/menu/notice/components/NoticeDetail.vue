<template>
  <div class="createPost-container">
    <el-form ref="postForm" :model="postForm" :rules="rules" class="form-container">
      <sticky :z-index="10" :class-name="'sub-navbar '+postForm.status">
        <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm">
          发表
        </el-button>
        <el-button v-loading="loading" type="warning" @click="draftForm">
          草稿
        </el-button>
      </sticky>
      <div class="createPost-main-container">
        <el-row>
          <el-col :span="24">
            <el-form-item style="margin-bottom: 40px;" prop="title">
              <MDinput v-model="postForm.title" :maxlength="100" name="name" required>
                标题
              </MDinput>
            </el-form-item>

            <div class="postInfo-container">
              <el-row>
                <el-col :span="8">
                  <el-form-item label-width="60px" label="作者:" class="postInfo-container-item">
                    <el-input v-model="postForm.author"   placeholder="作者">
                    </el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="10">
                  <el-form-item label-width="120px" label="发表时间:" class="postInfo-container-item">
                    <el-date-picker v-model="postForm.publishtime" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期和时间" />
                  </el-form-item>
                </el-col>


              </el-row>
            </div>
          </el-col>
        </el-row>

        <el-form-item prop="content" style="margin-bottom: 30px;">
          <Tinymce ref="editor" v-model="postForm.content" :height="800" />
        </el-form-item>



      </div>
    </el-form>
  </div>
</template>

<script>
import Tinymce from '@/components/Tinymce'
import MDinput from '@/components/MDinput'
import Sticky from '@/components/Sticky' // 粘性header组件
import { fetchNotice, createNotice, updateNotice, fetchList } from '@/api/notice'

const defaultForm = {
  title: '', // 文章题目
  content: '', // 文章内容
  author: '', // 文章作者
  publishtime: undefined, // 前台展示时间
  nid: undefined
}

export default {
  name: 'NoticeDetail',
  components: { Tinymce, MDinput, Sticky },
  props: {
    isEdit: {
      type: Boolean,
      default: false
    }
  },
  data() {
    const validateRequire = (rule, value, callback) => {
      if (value === '') {
        this.$message({
          message: rule.field + '为必传项',
          type: 'error'
        })
        callback(new Error(rule.field + '为必传项'))
      } else {
        callback()
      }
    }

    return {
      postForm: Object.assign({}, defaultForm),
      loading: false,
      tempRoute: {},
      rules: {
        title: [{ validator: validateRequire }],
        content: [{ validator: validateRequire }]
      }

    }
  },
  computed: {
    publishtime: {
      // set and get is useful when the data
      // returned by the back end api is different from the front end
      // back end return => "2013-06-25 06:59:25"
      // front end need timestamp => 1372114765000
      get() {
        return (+new Date(this.postForm.publishtime))
      },
      set(val) {
        this.postForm.publishtime = new Date(val)
      }
    }
  },
  created() {
    if (this.isEdit) {
      const nid = this.$route.params && this.$route.params.nid
      this.fetchData(nid)
    }

    // Why need to make a copy of this.$route here?
    // Because if you enter this page and quickly switch tag, may be in the execution of the setTagsViewTitle function, this.$route is no longer pointing to the current page
    // https://github.com/PanJiaChen/vue-element-admin/issues/1221
    this.tempRoute = Object.assign({}, this.$route)
  },

  watch: {
    '$router'(to, form) {
    // 路由发生变化页面刷新
      this.$router.go(0)
    }
  },
  methods: {

    fetchData(nid) {
      fetchNotice(nid).then(response => {
        this.postForm = response.data.data

        // just for test
        this.postForm.nid = this.postForm.nid
        this.postForm.author = this.postForm.author
        this.postForm.content = this.postForm.content
        this.postForm.publishtime = this.postForm.publishtime

        // set page title
        this.setPageTitle()
      }).catch(err => {
        console.log(err)
      })
    },

    submitForm() {
      console.log(this.postForm)
      if (this.isEdit) {
        updateNotice(this.postForm).then(res => {
          this.$notify({
            title: '成功',
            message: '更新公告成功',
            type: 'success',
            duration: 2000
          })

          this.loading = false
          this.$router.push({ path: '/notice_manage/list' })
        })
      } else {
        this.$refs.postForm.validate(valid => {
          if (valid) {
            this.loading = true
            // 发起请求
            createNotice(this.postForm).then(res => {
              this.$notify({
                title: '成功',
                message: '发布公告成功',
                type: 'success',
                duration: 2000
              })

              this.loading = false
              this.$router.push({ path: '/notice_manage/list' })
            })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      }
    },
    draftForm() {
      if (this.postForm.content.length === 0 || this.postForm.title.length === 0) {
        this.$message({
          message: '请填写必要的标题和内容',
          type: 'warning'
        })
        return
      }
      this.$message({
        message: '保存成功(模拟)',
        type: 'success',
        showClose: true,
        duration: 1000
      })
      this.postForm.status = 'draft'
    }

  }

}

</script>

<style lang="scss" scoped>
@import "~@/styles/mixin.scss";

.createPost-container {
  position: relative;

  .createPost-main-container {
    padding: 40px 45px 20px 50px;

    .postInfo-container {
      position: relative;
      @include clearfix;
      margin-bottom: 10px;

      .postInfo-container-item {
        float: left;
      }
    }
  }

  .word-counter {
    width: 40px;
    position: absolute;
    right: 10px;
    top: 0px;
  }
}

.article-textarea /deep/ {
  textarea {
    padding-right: 40px;
    resize: none;
    border: none;
    border-radius: 0px;
    border-bottom: 1px solid #bfcbd9;
  }
}
</style>
