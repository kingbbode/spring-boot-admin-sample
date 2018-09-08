import customEndpoint from './cache-detail';

SBA.use({
    install({viewRegistry}) {
        viewRegistry.addView({
            name: 'instances/cache-detail',
            parent: 'instances',
            path: 'cache-detail',
            component: customEndpoint,
            label: 'Custom',
            order: 1000,
            isEnabled: ({instance}) => {
                console.log('instance', instance);
                console.log('instance', instance.hasEndpoint);
                console.log('instance', instance.hasEndpoint('cache-detail'));

                return instance.hasEndpoint('cache-detail')
            }
    });
    }
});