<template>
    <div>
        测试
    </div>
</template>

<script>

    export default {
        name: "Post",
        created() {
            this.getList();
        },
        methods: {
            /** 查询帖子列表 */
            getList() {
                this.getRequest('/post/list').then(response => {
                    console.log(response)
                });
            }
        }
    }

</script>

<style scoped>

</style>