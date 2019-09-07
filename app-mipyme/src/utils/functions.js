//@Author William E. Velázquez A. - info@williamvelazquez.com
export const isEmptyObject = function(obj) {
  return Object.getOwnPropertyNames(obj).length === 0;
}

export const scrollToTop = () => {
  window.scrollTo({ top: 0});
}

export const smoothScrollToTop = () => {
  window.scrollTo({ top: 0, behavior: 'smooth' });
}

export const scrollToBottomById = function(id){
  let obj = document.getElementById(id);
  if(obj)
    obj.scrollTop = obj.scrollHeight + 200;
}