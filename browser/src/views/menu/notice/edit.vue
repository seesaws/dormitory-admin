<template>
  <notice-detail :is-edit="true" />
</template>

<script>
import NoticeDetail from './components/NoticeDetail'

export default {
  name: 'notice_edit',
  components: { NoticeDetail }
}
</script>

