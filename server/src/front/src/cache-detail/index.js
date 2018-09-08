import customEndpoint from './cache-detail';

SBA.use({
    install({viewRegistry}) {
        viewRegistry.addView({
            name: 'instances/cache-detail',
            parent: 'instances',
            path: 'cache-detail',
            component: customEndpoint,
            label: 'TEST CACHE',
            order: 1000,
            isEnabled: ({instance}) => instance.hasEndpoint('cache-detail')
    });
    }
});