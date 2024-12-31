import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchFilterCompetence'
})
export class SearchFilterCompetencePipe implements PipeTransform {
  transform(list: any[], filterText: string): any {
    
    if (!list || !filterText) {
      return list;
    }

    return list.filter(item => {
      if (item.nomCompetence && typeof item.nomCompetence === 'string') {
        const lowercaseNomCollaborateur = item.nomCompetence.toLowerCase();
        const lowercaseFilterText = filterText.toLowerCase();
        return lowercaseNomCollaborateur.includes(lowercaseFilterText);
      }
      return false;
    });
  }

}
