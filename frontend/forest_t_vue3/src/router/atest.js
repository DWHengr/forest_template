import layout from '@/components/layout/index.vue';

export default {
    path: '/test',
    component: layout,
    meta: { title: '测试页面' },
    children: [
        {
            path: '/index',
            name: 'test',
            meta: {
                title: '测试首页',
                parentName: '测试页面',
                path: '/index',
            },
            component: () => import('@/views/test.vue'),
        },
    ],
};
