<template>
    <sba-panel title="Test Cache">
        <table class="table is-fullwidth">
            <tr v-if="caches && caches.data && caches.data.length > 0">
                <td class="health-details__nested" colspan="2">
                    <table class="health-details table is-fullwidth">
                        <tr class="health-details__detail" v-for="cache in caches.data" :key="cache.id">
                            <td v-text="cache.id"/>
                            <td v-text="cache.text"/>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </sba-panel>
</template>

<script>
    export default {
        props: {
            instance: {
                type: Object,
                required: true
            }
        },
        data: () => ({
            caches: {
                data : []
            }
        }),
        async created() {
            const response = await this.instance.axios.get('actuator/cache-detail'); //<2>
            this.caches = response.data;
        }
    };
</script>

<style>
    .custom {
        font-size: 20px;
        width: 80%;
    }
</style>