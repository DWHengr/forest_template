import { NIcon } from 'naive-ui';
import { h } from 'vue';
import {
    SettingsSuggestTwotone,
    TipsAndUpdatesTwotone,
} from '@vicons/material';

function renderIcon(icon) {
    return () => h(NIcon, null, { default: () => h(icon) });
}

export const menus = [
    {
        label: '测试',
        key: '1',
        icon: renderIcon(SettingsSuggestTwotone),
        children: [
            {
                label: '测试页面',
                key: 'test',
                icon: renderIcon(TipsAndUpdatesTwotone),
            },
        ],
    },
];
