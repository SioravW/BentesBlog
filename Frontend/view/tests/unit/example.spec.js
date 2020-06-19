import { shallowMount } from '@vue/test-utils'
import Home from '@/views/Home.vue'

describe('Home.vue', () => {
  it('has title', () => {
    const wrapper = shallowMount(Home)
    expect(wrapper.html()).toContain('<h2>Bloggers:</h2>')
  })
})