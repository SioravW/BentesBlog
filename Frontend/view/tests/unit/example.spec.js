import { shallowMount } from '@vue/test-utils'
import Home from '@/views/Home.vue'

describe('Home.vue', () => {
  it('shows the title', () => {
    const wrapper = shallowMount(Home)
    expect(wrapper.contains('Bloggers:')).toBe(true)
  })
})