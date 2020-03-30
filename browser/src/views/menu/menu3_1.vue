<template>
  <div class="dashboard-editor-container">
    <div class=" clearfix">
      <div class="pan-item" >
        <div class="pan-info"></div>
        <img class="pan-thumb" :src="form.headimgsrc" >
      </div>
      <div class="info-container">
        <!-- <span class="display_name">{{nick}}</span> -->
        <div style="font-size: 38px;line-height: 38px;color: #212121;padding-top: 15px;">
          {{nick}}
        </div>
        <div>
          <span style="font-size:20px;padding-top:20px;display:inline-block;">角色：</span>
          <el-tag style="margin-right: 5px;" type="danger" v-if="roles.length==0" >游客（未配置任何角色）</el-tag>
          <el-tag style="margin-right: 5px;" type="success" v-else v-for="r in roles" :key="r.val">{{r.name}}</el-tag>
        </div>
        <div>
          <span style="font-size:20px;padding-top:20px;display:inline-block;">权限：</span>
          <el-tag style="margin-right: 5px;" type="danger" v-if="perms.length==0">未配置任何权限</el-tag>
          <el-tag style="margin-right: 5px;" type="info" v-else v-for="r in perms" :key="r.val">{{r.name}}</el-tag>
        </div>

      </div>
    </div>

      <el-form ref="form" :model="form" label-width="80px" class="form1">

        <el-row>
          <el-col :span="6">
              <el-form-item label="uid">
                  <el-input v-model="form.uid"  :disabled="true"></el-input>
              </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6">
              <el-form-item label="学号">
                  <el-input prefix-icon="el-icon-warning-outline" v-model="form.stuno" clearable></el-input>
              </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-form-item label="性别">
            <el-radio-group v-model="form.gender">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
        </el-row>

        <el-row>
          <el-col :span="6">
              <el-form-item label="年龄">
                  <el-input prefix-icon="el-icon-user" v-model="form.age" clearable></el-input>
              </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6">
              <el-form-item label="地址">
                  <el-input prefix-icon="el-icon-location-outline" v-model="form.address" clearable></el-input>
              </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6">
              <el-form-item label="电话">
                  <el-input prefix-icon="el-icon-phone-outline" v-model="form.phone" clearable></el-input>
              </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6">
            <el-form-item label-width="80px" label="登记日期:">
              <el-date-picker v-model="form.checkin" type="datetime" format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期和时间" :editable="false" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item>
          <el-button type="primary" @click="onSubmit" round>更新或保存</el-button>

        </el-form-item>
      </el-form>

  </div>

</template>


<script>
  import { mapGetters } from 'vuex'
  import PanThumb from '@/components/PanThumb'
  import { fetchDetail, updateDetail } from '@/api/student'
  // 默认导出
  export default {
    name: 'myinfo',
    components: { PanThumb },
    data() {
      return {

        form: {
          uid: '',
          stuno: '',
          stuname: '',
          gender: '',
          age: '',
          address: '',
          phone: '',
          headimgsrc: '',
          checkin: ''
        }
      }
    },
    computed: {
      ...mapGetters([
        'name',
        'nick',
        'avatar',
        'roles',
        'perms'
      ])
    },
    created() {
      this.initData()
    },
    methods: {
      onSubmit() {
        console.log(this.form)

        updateDetail(this.form).then(res => {
          console.log(res)
          this.$message({
            message: '信息更新成功',
            type: 'success'
          })
        }).catch(err => {
          console.log(err)
        })
      },
      initData() {
        fetchDetail().then(res => {
          console.log(res)

          this.form.uid = res.data.student.uid
          this.form.stuno = res.data.student.stuno
          this.form.gender = res.data.student.gender
          this.form.age = res.data.student.age
          this.form.address = res.data.student.address
          this.form.phone = res.data.student.phone
          this.form.checkin = res.data.student.checkin
          this.form.headimgsrc = res.data.student.headimgsrc
        }).catch(err => {
          console.log(err)
        })
      }

    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .pan-info {
    position: absolute;
    width: inherit;
    height: inherit;
    border-radius: 50%;
    overflow: hidden;
    box-shadow: inset 0 0 0 5px rgba(0, 0, 0, 0.05);
  }
  .pan-item {
    float: left;
    z-index: 1;
    width: 150px;
    height: 150px;
    border-radius: 50%;
    display: inline-block;
    position: relative;
    cursor: default;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
  }
  .pan-thumb {
    width: 100%;
    height: 100%;
    background-size: 100%;
    border-radius: 50%;
    overflow: hidden;
    position: absolute;
    transform-origin: 95% 40%;
    transition: all 0.3s ease-in-out;
  }

  .emptyGif {
    display: block;
    width: 45%;
    margin: 0 auto;
  }

  .dashboard-editor-container {
    background-color: #F2F6FC;
    min-height: 100vh;
    padding: 50px 60px 0px;
    .pan-info-roles {
      font-size: 12px;
      font-weight: 700;
      color: #333;
      display: block;
    }
    .info-container {
      position: relative;
      margin-left: 190px;
      height: 80px;
      /*line-height: 80px;*/
      .display_name {
        font-size: 38px;
        line-height: 38px;
        color: #212121;
        position: absolute;
        top: 25px;
      }
    }
  }

</style>
