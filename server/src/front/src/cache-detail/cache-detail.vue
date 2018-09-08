<template>
    <sba-panel title="Test Cache">
        <table class="table is-fullwidth">
            <tr v-if="caches && caches.data && caches.data.length > 0">
                <td colspan="2">
                    <table class="table is-fullwidth">
                        <tr v-for="cache in caches.data" :key="cache.id">
                            <td v-text="cache.id"/>
                            <td v-text="cache.text"/>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr v-else>
                <td colspan="2">
                    <table class="table is-fullwidth">
                        <tr>데이터가 없습니다.</tr>
                    </table>
                </td>
            </tr>
        </table>
    </sba-panel>
</template>

<script>
    import {timer} from 'rxjs/internal/observable/timer';

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
        created() {
            this.fetch()
        },
        methods: {
            async fetch() {
                const response = await this.instance.axios.get('actuator/cache-detail');
                this.caches = response.data;
            },
            createSubscription() {
                const vm = this;
                return timer(0, 2000)
                    .subscribe(val => vm.fetch());
            }
        }
    };
</script>

<style>
</style>