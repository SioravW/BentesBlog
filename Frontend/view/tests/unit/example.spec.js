import { shallowMount } from '@vue/test-utils'
import Home from '@/views/Home.vue'
import AddPicture from '@/views/AddPicture.vue'

describe('Home.vue', () => {
  it('has title', () => {
    const wrapper = shallowMount(Home)
    expect(wrapper.html()).toContain('<h2>Bloggers:</h2>')
  })
  it('has not an p', () => {
    const wrapper = shallowMount(Home)
    expect(wrapper.contains('p')).toBe(false)
  })
  it('has not an p', () => {
    const wrapper = shallowMount(Home)
    expect(wrapper.contains('input')).toBe(false)
  })
})

describe('AddPicture.vue', () => {
  it('has button', () =>
  {
    const wrapper = shallowMount(AddPicture)
    expect(wrapper.contains('input')).toBe(true)
  })
})
