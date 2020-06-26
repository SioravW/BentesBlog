// https://docs.cypress.io/api/introduction/api.html

describe('Home', () => {
  it('Visits the app root url', () => {
    cy.visit('/')
    cy.contains('h4', 'Siora')
    cy.contains('a', 'Bente in IJsland')
  })
})

describe('Home page to post', () => {
  it('Visit home page', () => {
    cy.visit('/')
    cy.contains('a','Siora')
    cy.contains('a', 'Bente in IJsland')
  })
  it('Visit blogger', () => {
    cy.get('.bloggerName').first().click()
    cy.contains('a', 'Minor')
    cy.contains('a', 'Bente in IJsland')
  })
  it('Visit Jouney', () => {
    cy.get('.journeyName').first().click()
    cy.contains('a', 'Eerste dag school in Ijsland')
    cy.contains('a', 'Bente in IJsland')
  })
  it('Visit post', () => {
    cy.get('.postName').first().click()
    cy.contains('p')
    cy.contains('a', 'Bente in IJsland')
  })
})

describe('Header test', () => {
  it('Homepage', () => {
    cy.visit('/')
    cy.contains('a', 'Siora')
    cy.get('a').first().click()
    cy.contains('a', 'Siora')
  })
  it('Bloggerpage', () => {
    cy.visit('/#/blogger/1')
    cy.contains('a', 'Minor')
    cy.get('a').first().click()
    cy.contains('a', 'Siora')
  })
  it('Journeypage', () => {
    cy.visit('/#/Journey/1')
    cy.contains('a', 'Eerste dag school in Ijsland')
    cy.get('a').first().click()
    cy.contains('a', 'Siora')
  })
  it('Postpage', () => {
    cy.visit('/#/Post/2')
    cy.contains('p')
    cy.get('a').first().click()
    cy.contains('a', 'Siora')
  })
  it('Addpicture page', () => {
    cy.visit('/#/Post/2/AddPicture')
    cy.get('a').first().click()
    cy.contains('a', 'Siora')
  })
})