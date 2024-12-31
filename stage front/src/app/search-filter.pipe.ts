import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {
  transform(list: any[], filterText: string): any {
    
    if (!list || !filterText) {
      return list;
    }

    return list.filter(item => {
      if (item.nomCollaborateur && typeof item.nomCollaborateur === 'string') {
        const lowercaseNomCollaborateur = item.nomCollaborateur.toLowerCase();
        const lowercaseFilterText = filterText.toLowerCase();
        return lowercaseNomCollaborateur.includes(lowercaseFilterText);
      }
      return false;
    });
  }
}

